package com.mdval;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.mdval.config.OracleDataSourceConfig;
import com.mdval.utils.LiteralesSingleton;

@SpringBootTest
@ContextConfiguration(classes = {OracleDataSourceConfig.class})
class MDValApplicationTests {

	@MockBean
	private DataSource dataSource;

	@Test
	void contextLoads() {
		try {
			LiteralesSingleton literales = LiteralesSingleton.getInstance();
			assertNotEquals(literales.getLiteral("menu.configuracion"), StringUtils.EMPTY);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
