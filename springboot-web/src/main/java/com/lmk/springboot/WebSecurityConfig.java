package com.lmk.springboot;

import com.lmk.springboot.service.SysUserService;
import com.lmk.springboot.service.impl.LoginSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    LoginSecurityService loginSecurityService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginSecurityService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                //return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
                return charSequence.toString();
            }

            /**
             * @param charSequence 明文
             * @param s 密文
             * @return
             */
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                //return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
                return s.equals(charSequence.toString());
            }
        });
    }

    /**
     * http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
     *                 .and()
     *                 .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
     *                 .anyRequest()               // 任何请求,登录后可以访问
     *                 .authenticated();
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("AMDIN")
                .antMatchers("/index").anonymous()
                .antMatchers("/login").anonymous()
                .anyRequest().authenticated()//其他的路径都是登录后即可访问
                .and()
                .formLogin()
                .loginPage("/login")//未登录直接写页面地址跳转到这里处理
                .loginProcessingUrl("/loginOnForm")//post请求时处理请求 不用在controller中写出 会使用自定义的userdetailservice进行验证
                .usernameParameter("username").passwordParameter("password").permitAll()
                .defaultSuccessUrl("/dashboard")
                .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                            httpServletResponse.setContentType("application/json;charset=utf-8");
                            PrintWriter out = httpServletResponse.getWriter();
                            out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
                            out.flush();
                            out.close();
                        }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and().logout().permitAll().and().csrf().disable();*/
       /* http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("超级管理员")
                .antMatchers("/index").anonymous()
                .anyRequest().authenticated()//其他的路径都是登录后即可访问
                .and()
                .formLogin().loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                })
                .loginProcessingUrl("/loginOnForm")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and().logout().permitAll().and().csrf().disable();*/


        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginOnForm")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                })
                .and().authorizeRequests()
                        .antMatchers("/index").permitAll()
                        .anyRequest()
                        .authenticated()
                .and().csrf().disable();
    }

    /*注意spring boot 默认静态位置就在 static 文件夹下 无需多加一层*/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login.html","/js/**","/css/**","/login");
    }
}
