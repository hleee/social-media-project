package com.mycompany.myapp.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TokenMaker {

	public String makeToken() {
		int length = 64;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();

		String[] charArray = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");
		for (int i = 0; i < length; i++) {
			buffer.append(charArray[random.nextInt(charArray.length)]);
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}

}
