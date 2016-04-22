package bpmis.pxc.system.controller.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pxcbpmisframework.core.exception.BusinessException;

public class UploadServlet extends HttpServlet {
	private static final Logger log = LogManager.getLogger(UploadServlet.class);
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savePath = this.getServletConfig().getServletContext()
				.getRealPath("");
		savePath = "E:/log/upload/";
		String tempPath = "E:/log/upload/temp/";
		System.out.println(savePath);
		// 创建文件夹
		File dirfile = new File(savePath);
		if (!dirfile.exists()) {
			dirfile.mkdirs();
		}
		// 创建临时文件夹
		File dirTempFile = new File(tempPath);
		if (!dirTempFile.exists()) {
			dirTempFile.mkdirs();
		}
		//
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4 * 1024 * 1024);// 设置向硬盘写数据时所用的缓冲区的大小，此处为4K
		factory.setRepository(new File(tempPath)); // 设定存储临时文件的目录。
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置允许上传的文件的最大尺寸，此处为4M
		//upload.setSizeMax(5 * 1024 * 1024);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> fileList = null;
		try {
			fileList = upload.parseRequest(request);// 上传文件，并解析出所有的表单字段，包括普通字段和文件字段

			// 下面对每个字段进行处理，分普通字段和文件字段
			Iterator<FileItem> it = fileList.iterator();
			String name = "";
			String extName = "";
			while (it.hasNext()) {
				FileItem item = it.next();
				if (!item.isFormField()) { // 不是普通字段
					name = item.getName();
					System.out.println(name);
					long size = item.getSize();
					String type = item.getContentType();
					System.out.println(size + " " + type);
					if (name == null || name.trim().equals("")) {
						continue;
					}
					// 扩展名格式：
					if (name.lastIndexOf(".") >= 0) {
						extName = name.substring(name.lastIndexOf("."));
					}
					File file = null;
					System.out.println(savePath + name + extName);
					do {
						// 生成文件名：
						name = UUID.randomUUID().toString();
						file = new File(savePath + name + extName);
					} while (file.exists());
					System.out.println(savePath + name + extName);
					File saveFile = new File(savePath + name + extName);
					try {
						item.write(saveFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			response.getWriter().print(name + extName);

		} catch (FileUploadException ex) {
			new BusinessException(ex);
		}
	}
}
