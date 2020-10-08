package com.backstage.service.Impl;

import com.backstage.dao.SysLogDao;
import com.backstage.pojo.SysLog;
import com.backstage.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    protected SysLogDao sysLogDao;

    @Autowired
    public void setSysLogDao(SysLogDao sysLogDao){
        this.sysLogDao =sysLogDao;
    }

    @Override
    public void saveSyslog(SysLog sysLog) {
        sysLogDao.saveSyslog(sysLog);
    }

    @Override
    public boolean deleteSyslogById(String id) {
        if(sysLogDao.deleteSyslogById(id) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<SysLog> findAllSyslog(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return sysLogDao.findAllSyslog();
    }
}
