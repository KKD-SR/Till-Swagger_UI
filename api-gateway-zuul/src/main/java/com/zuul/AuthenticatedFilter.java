package com.zuul;
/*package com.main;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;



public class AuthenticatedFilter extends ZuulFilter {

	  @Override
	  public String filterType() {
	    return "pre";
	  }

	  @Override
	  public int filterOrder() {
	    return 10;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	  public Object run() {
	    RequestContext ctx = RequestContext.getCurrentContext();
	    String auth ="username" + ":" + "password";
	    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
	    String authValue = "Basic " + new String(encodedAuth);
	    ctx.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, authValue);        
	    return null;
	  }
	}*/