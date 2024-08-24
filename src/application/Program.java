package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> lessons = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int quantityOfLessons = sc.nextInt();
		
		for (int i = 1; i <= quantityOfLessons; i++) {
			System.out.println("\nDados da " + i + "a aula:");
			
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char lessonType = sc.next().charAt(0);
			
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if (lessonType == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				
				lessons.add(new Video(title, url, duration));
			}
			else if (lessonType == 't') {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				
				lessons.add(new Task(title, description, questionCount));
			}
		}
		
		int totalDuration = 0;
		
		for (Lesson lesson : lessons) {
			totalDuration += lesson.duration();
		}
		
		System.out.println();
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");
		
		sc.close();
	}

}
