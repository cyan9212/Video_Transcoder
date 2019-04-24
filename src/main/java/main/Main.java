package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import transcoder.Worker;
import ui.JobCLI;

public class Main {

	private static ApplicationContext context;

	// DI with Java Configuration
	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(TranscoderConfig.class);

		final Worker worker = (Worker) context.getBean(Worker.class);
		JobCLI cli = (JobCLI) context.getBean(JobCLI.class);

		Thread t = new Thread(new Runnable() {
			public void run() {
				worker.run();
			}
		});

		cli.interact();

		t.run();
	}
}
