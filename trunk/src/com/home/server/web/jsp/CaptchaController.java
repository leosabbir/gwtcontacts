package com.home.server.web.jsp;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.CaptchaException;

@Controller
public class CaptchaController {
	private final ImageCaptchaService imageCaptchaService;
	
	public CaptchaController(ImageCaptchaService imageCaptchaService) {
		this.imageCaptchaService = imageCaptchaService;
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/png");

		String captchaId = request.getSession().getId();

		// sometimes the generated captcha does not fit into the image, we retry three times
		// to virtually ensure the user won't notice this
		int retries = 3;
		BufferedImage challenge = null;

		do {
			try {
				challenge = imageCaptchaService.getImageChallengeForID(captchaId, new Locale("en_US"));
			} catch (CaptchaException e) {
				if (retries < 0) throw e;
			}
			retries--;
		} while (challenge == null);

		OutputStream outputStream = response.getOutputStream();
		ImageIO.write(challenge, "png", outputStream);
		outputStream.close();
	}
}
