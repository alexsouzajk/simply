package br.com.simply;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	/**
	 * Verifica se houve chamada do método OPTIONS padrão do navegador se afirmativo verifica se esta 
	 * relacionado com originPermitida, se positivo libera com os methods aceitos
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		/* Setando a origem autorizada */
		resp.setHeader("Access-Control-Allow-Origin", "*");
		/* Confirmando a necessidade de credenciais */
		resp.setHeader("Access-Control-Allow-Credentials", "true");

		if("OPTIONS".equals(req.getMethod())) {

			/* Methods liberados */
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			resp.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			/* Tempo de expiração da autorização em questão */
			resp.setHeader("Access-Control-Max-Age", "3600");
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}