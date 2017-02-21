package ether.analysis;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import ether.analysis.service.impl.ExtractionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class EthpoolExtractorApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EthpoolExtractorApplication.class, args).close();
	}


	@Autowired
	private ExtractionServiceImpl creditExtractionThread;

	public static final MetricRegistry metricRegistry = new MetricRegistry();

	@Override
	public void run(String... strings) throws Exception {

		startPerformanceReporting();

		while (true){
			creditExtractionThread.extractCredits();
			Thread.sleep(4000);
		}
	}


	/**
	 * Starts performance reporting.
	 * Output goes to console.
	 */
	protected static void startPerformanceReporting() {
		ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
				.convertRatesTo(TimeUnit.SECONDS)
				.convertDurationsTo(TimeUnit.MILLISECONDS)
				.build();
		reporter.start(1, TimeUnit.MINUTES);
	}
}
