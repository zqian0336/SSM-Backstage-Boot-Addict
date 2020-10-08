package com.backstage.dao;

import com.backstage.pojo.SysLog;

import java.util.List;

public interface SysLogDao {

    void saveSyslog(SysLog sysLog);

    int deleteSyslogById(String id);

    List<SysLog> findAllSyslog();
}
