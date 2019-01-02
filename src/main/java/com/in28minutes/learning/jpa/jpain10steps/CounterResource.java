package com.in28minutes.learning.jpa.jpain10steps;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.conditional.IfAction;
import ch.qos.logback.core.util.Duration;

@RestController
public class CounterResource {
	
	@GetMapping(path="/")
	public String helloWorld() {
		
		ZonedDateTime meetingDate = LocalDateTime.of(2019,6,15,19,0).atZone(ZoneId.of("Europe/Warsaw"));
		ZonedDateTime nowDate =  LocalDateTime.now(ZoneId.of("Europe/Warsaw")).atZone(ZoneId.of("Europe/Warsaw"));
		
		if (meetingDate.isAfter(nowDate)) {

			ZonedDateTime tempDateTime = ZonedDateTime.from( nowDate );

			long years = tempDateTime.until( meetingDate, ChronoUnit.YEARS);
			tempDateTime = tempDateTime.plusYears( years );

			long months = tempDateTime.until( meetingDate, ChronoUnit.MONTHS);
			tempDateTime = tempDateTime.plusMonths( months );

			long days = tempDateTime.until( meetingDate, ChronoUnit.DAYS);
			tempDateTime = tempDateTime.plusDays( days );


			long hours = tempDateTime.until( meetingDate, ChronoUnit.HOURS);
			tempDateTime = tempDateTime.plusHours( hours );

			long minutes = tempDateTime.until( meetingDate, ChronoUnit.MINUTES);
			tempDateTime = tempDateTime.plusMinutes( minutes );

			long seconds = tempDateTime.until( meetingDate, ChronoUnit.SECONDS);
			
			
			return "<b>Do spotkania pozostało około: </b> " + months + " miesięcy, " + days + " dni, " + hours + " godzin, " + minutes + " minut, " + seconds + " sekund.";
			
		} else {
			return "<b>Termin spotkania minął.</b>";
		}
	}
}
