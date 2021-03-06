package br.gov.basis.sap.sapservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

import br.gov.nuvem.comum.microsservico.config.SecurityConfigurationComum;
import br.gov.nuvem.seguranca.jhipsterjwt.security.jwt.TokenProvider;
import br.gov.nuvem.seguranca.jhipsterjwt.security.token.TokenResolver;
import br.gov.nuvem.seguranca.jhipsterjwt.security.AuthoritiesConstants;

@Configuration
public class SecurityConfiguration extends SecurityConfigurationComum {

    public SecurityConfiguration(
        TokenProvider tokenProvider,
        TokenResolver tokenResolver,
        SecurityProblemSupport problemSupport) {
        super(tokenProvider, tokenResolver, problemSupport);
    }

    @Override
    public void configureApp(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/management/health").permitAll()
            .antMatchers("/management/info").permitAll()
            .antMatchers("/management/prometheus").permitAll()
            .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN);
    }

}
