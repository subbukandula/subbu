package com.subbu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UsesResourceBundle.class})
public class JTesting {
	
	@Mock
	UsesResourceBundle userResBundle;
	
	@InjectMocks
	ClasstoTest classtoTest;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMethodToTest() throws Exception {
		PowerMockito.mockStatic(UsesResourceBundle.class);
		PowerMockito.when(UsesResourceBundle.handleInt()).thenReturn(10);
		PowerMockito.when(UsesResourceBundle.handleString()).thenReturn("Subbu");
		PowerMockito.doNothing().when(UsesResourceBundle.class, "handleVoid");
		Mockito.when(userResBundle.handleNonStaticInt()).thenReturn(20);
		Mockito.when(userResBundle.handleNonStaticString()).thenReturn("Venkat");
		Mockito.doNothing().when(userResBundle).handleNonStaticVoid();
		classtoTest.methodToTest();
	}

}
