package com.wasu.vrsite.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wasu.vrsite.entity.AppInfo;



public class TerminalInterceptor implements HandlerInterceptor {
	
	private static final ThreadLocal<TerminalInfo> terminalInfoHold = new ThreadLocal<TerminalInfo>();
	private static Logger logger = Logger.getLogger(TerminalInterceptor.class);
	
    public static TerminalInfo getTerminalInfo(){
        return terminalInfoHold.get();
    }

    public static HttpServletRequest getRequest(){
        TerminalInfo terminalInfo = terminalInfoHold.get();
        if(terminalInfo!=null){
            return  terminalInfo.getRequest();
        }
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
	
    public static AppInfo getAppInfo(){
        TerminalInfo terminalInfo = terminalInfoHold.get();
        if(terminalInfo!=null){
            return  terminalInfo.getAppInfo();
        }
        return new AppInfo();
    }
	

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        terminalInfoHold.set(new TerminalInfo(request));
        logger.info(request.getRequestURI());
        return true;
    }

    public static class TerminalInfo{

        private HttpServletRequest request;

        private AppInfo appInfo;

        public TerminalInfo(HttpServletRequest request){
            this.setRequest(request);
        }

        public HttpServletRequest getRequest() {
            return request;
        }

        public void setRequest(HttpServletRequest request) {
            this.appInfo = new AppInfo();
            if(request!=null){
                this.appInfo.setIMEI(request.getHeader("IMEI"));
                logger.info("IMEI:--------------------------------"+this.appInfo.getIMEI());
            }
            this.request = request;
        }

        public AppInfo getAppInfo() {
            return appInfo;
        }

        public void setAppInfo(AppInfo appInfo) {
            this.appInfo = appInfo;
        }
    }
}
