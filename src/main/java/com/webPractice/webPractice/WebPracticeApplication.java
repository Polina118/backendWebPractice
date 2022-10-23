package com.webPractice.webPractice;

import com.webPractice.webPractice.Appeals.Appeals;
import com.webPractice.webPractice.News.News;
import com.webPractice.webPractice.News.NewsRepository;
import com.webPractice.webPractice.Appeals.AppealsRepository;
import com.webPractice.webPractice.User.User;
import com.webPractice.webPractice.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebPracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepo,
										NewsRepository newsRepo) {
		return args -> {
			try {
				User admin = new User(
						"admin",
						"admin",
						"Студент",
						"admin@gmail.com",
						"password",
						null);
				admin.set_Admin(true);
				User polina = new User(
						"polina",
						"gg",
						"Студент",
						"pol@gmail.com",
						"polina",
						"ВПР21");
				User serg = new User(
						"Сергей",
						"Чалый",
						"Студент",
						"login@gmail.com",
						"123",
						"ВМО31");

//			Appeals answer1 = new Appeals(polina.getName() +" "+ polina.getSurname(), "text of answer");
			News news1 = new News("title", "text of news1", "учебные новости");
//			admin.addAppeal(answer1);
			userRepo.save(admin);
			userRepo.save(serg);
			newsRepo.save(news1);
			}
			catch (Exception e) {
				throw new Exception("error");
			}
		};
	}
}
