package ether.analysis;

import ether.analysis.thread.ExtractionThread;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class EthpoolExtractorApplication implements CommandLineRunner{

	@Autowired
	private ExtractionThread extractionThread;

	public static void main(String[] args) {
		SpringApplication.run(EthpoolExtractorApplication.class, args).close();
	}

	@Override
	public void run(String... strings) throws Exception {
		extractionThread.run();
	}
}
