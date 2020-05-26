/**
 * 
 */
package callcenter.filter;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author firsov
 *
 */
class JobFileTest {

	private JobFile jobFile;
	
	private String path = "src/test/resources/";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		jobFile = new JobFile();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindFileDocxFolder() throws Exception {
		int expected = 1;
		int actual = jobFile.findFileDocxFolder(path).size();
		assertEquals(expected, actual);
	}
	
	@Test
	void testReatFirstTable() throws Exception {
		List<CallcenterEntity> expected = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		CallcenterEntity callcenterEntity = new CallcenterEntity().newBuilder()
				.withNumber("0-96330/1")
				.withDateCorrespondent(new Date(format.parse("17.02.2020").getTime()))
				.withDateDue(new Date(format.parse("14.02.2020").getTime()))
				.withCorrespondent("гр. Буркацька Галина Миколаївна")
				.withSummary("Щодо прохання демонтувати РЗ за адресою : просп. Голосіївський, 126").build();
		expected.add(callcenterEntity);
		List<CallcenterEntity> actual = jobFile.parseFile(jobFile.findFileDocxFolder(path).get(0));
		assertEquals(expected, actual);
	}

	/*
	@Test
	void testReadFile() throws Exception {
		
		JobFile jobFile = new JobFile();
		List<CallcenterEntity> actual = jobFile.readFileDocx(new File("src/test/resources/test_filter.docx"));
		//assertEquals(expected.size(), actual.size());
		assertEquals(expected, actual);
	}
*/
}
