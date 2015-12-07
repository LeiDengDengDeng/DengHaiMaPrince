package src.main;

import src.dataservice.datafactoryservice.DataFactoryService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.po.LogPO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by dell on 2015/12/4.
 * ”√Õæ
 */
public class TestRMIMain {

    public static void main(String[] args) {
        try {
            LogDataService logData = (LogDataService) Naming.lookup("rmi://127.0.0.1:6600/logData");
            SheetDataService sheetData = (SheetDataService) Naming.lookup("rmi://127.0.0.1:6600/sheetData");
            System.out.println(logData.findAll().get(0).getName());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("success!");
    }

}
