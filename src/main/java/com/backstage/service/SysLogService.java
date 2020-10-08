package com.backstage.service;

import com.backstage.pojo.SysLog;

import java.util.List;

public interface SysLogService {

    void saveSyslog(SysLog sysLog);

    boolean deleteSyslogById(String id);

    List<SysLog> findAllSyslog(int page, int pageSize);
}
