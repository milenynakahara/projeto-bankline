package com.bankline.utils;

import net.bytebuddy.implementation.bytecode.Throw;

public class CpfUtils {
	public boolean validarCPF(String cpf) throws Exception {
		formatarCpf(cpf);
		if(cpf == null || !cpf.matches("^[0-9]*") || cpf.length() != 11) { 
			return false;
		}
		else
		return true;
	}
	public static String formatarCpf(String cpf) throws Exception {
		cpf = cpf.replaceAll("\\D","");
		return cpf;
	}
}
