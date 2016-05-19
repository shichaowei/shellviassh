package com.tairan.fengdai.task;

import com.tairanchina.FengDai.constants.Test360FengdaiConstants;
import com.tairanchina.unit.shell.ShellExecute;

public class TaskResettomcat {
	
	public TaskResettomcat(String cmd){
		ShellExecute operatomcat=new ShellExecute();
		operatomcat.remoteRunCmd(Test360FengdaiConstants.IPADDRESS, Test360FengdaiConstants.SSHUSER,
				Test360FengdaiConstants.SSHPWD, cmd);
		String checktomcat="ps -ef | grep tomcat| grep -v grep |grep -v cmsdeploy | grep -v killpro \n";
		while(operatomcat.remoteRunCmd(Test360FengdaiConstants.IPADDRESS, Test360FengdaiConstants.SSHUSER,Test360FengdaiConstants.SSHPWD, checktomcat).equals("")){
			operatomcat.remoteRunCmd(Test360FengdaiConstants.IPADDRESS, Test360FengdaiConstants.SSHUSER,Test360FengdaiConstants.SSHPWD, cmd);
    	}
		
	}

}
