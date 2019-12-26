/**
 * 
 */
package com.personal.fervour.configurations;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author vignesh
 *
 */
@Configuration
public class LocaleContentHandler {

	@Bean
	public LocaleResolver handleLocaleLanguage() {
		final SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageBundle() {
		final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
