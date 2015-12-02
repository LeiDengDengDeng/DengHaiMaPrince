package src.businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;
import src.businesslogic.util.CommonUtil;
import src.vo.LogVO;

public class Log implements LogBLService {

    LogDataService logData;

    public Log(LogDataService logData) {
        this.logData = logData;
    }

    @Override
    public ArrayList<LogVO> checkLog(String date) {
        // TODO �Զ����ɵķ������
        ArrayList<LogVO> logVOs = new ArrayList<>();
        try {
            ArrayList<LogPO> logPOs = logData.findAll();

            // dateΪ�գ�����������־
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
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }

        return logVOs;
    }

    @Override
    public void generateLog(String position, String name, String operation,
                            String statement) {
        // TODO �Զ����ɵķ������
        LogPO log = new LogPO(position, name, operation, statement,
                CommonUtil.getDate());

        try {
            logData.insert(log);
        } catch (RemoteException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
    }
}
