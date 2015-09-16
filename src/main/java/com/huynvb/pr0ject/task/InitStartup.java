package com.huynvb.pr0ject.task;

import java.util.Timer;

import com.huynvb.pr0ject.common.ConfigProperties;
import com.huynvb.pr0ject.common.Constant;
import com.huynvb.pr0ject.common.CopyrightException;

public class InitStartup {
	private Timer timer;
	private String COPYRIGHT_KEY_PROPERTY = "copyrightKey";
	private String OFFICE_ID = "officeID";
	
	public static void main(String[] args) {
	}

	public void run() throws Exception {
		String officeID = ConfigProperties.getConfigProperties(OFFICE_ID);
		String copyrightKey = ConfigProperties.getConfigProperties(COPYRIGHT_KEY_PROPERTY);
		
		String str = officeID + "_" + Constant.getMacAddress();
		String strCopyright = Constant.encryptMD5(str);
		
		//Authenticate Copyright
		if(!strCopyright.equals(copyrightKey)){
			throw new CopyrightException("Copyright is not valid.");
		}
	}
}
