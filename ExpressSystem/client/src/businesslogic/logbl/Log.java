package src.businesslogic.logbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.loginbl.LogIn;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;
import src.businesslogic.util.CommonUtil;
import src.vo.LogVO;

public class Log implements LogBLService {

    LogDataService logData;

    public Log() {
        try {
            this.logData = (LogDataService) Naming.lookup("rmi://127.0.0.1:6600/logData");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<LogVO> checkLog(String date) {
        // TODO 自动生成的方法存根
        ArrayList<LogVO> logVOs = new ArrayList<>();
        try {
            ArrayList<LogPO> logPOs = logData.findAll();

            // date为空，返回所有日志
            if (date == null) {
                for (LogPO log : logPOs)
                    logVOs.add(new LogVO(log.getPosition(), log.getName(), log.getOperation(), log.getStatement(),
                            log.getDate()));
            } else {
                for (LogPO log : logPOs)
                    if (log.getDate().equals(date))
                        logVOs.add(new LogVO(log.getPosition(), log.getName(), log.getOperation(), log.getStatement(),
                                log.getDate()));
            }
        } catch (RemoteException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        return logVOs;
    }

    @Override
    public void generateLog(String operation, String statement) {
        // TODO 自动生成的方法存根
        LogPO log = new LogPO(LogIn.currentUser.getMyPosition(), LogIn.currentUser.getpersonalName(), operation,
                statement, CommonUtil.getDate());

        try {
            logData.insert(log);
        } catch (RemoteException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
