package fa.appcode.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fa.appcode.dao.CandidateDaoImpl;
import fa.appcode.entities.Candidate;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CandidateTest {

	@InjectMocks
	private CandidateServiceImpl candidateServiceImpl;

	@Mock
	private CandidateDaoImpl candidateDaoImpl;

	@Test
	public void testFindCandidateById() throws Exception {
		Candidate candidate = new Candidate();
		candidate.setCandidateId(1);
		when(candidateDaoImpl.findByIdCandidate(1)).thenReturn(candidate);
		assertEquals(candidateServiceImpl.doFindByIdCandidate(1).getCandidateId(), candidate.getCandidateId());
	}
}