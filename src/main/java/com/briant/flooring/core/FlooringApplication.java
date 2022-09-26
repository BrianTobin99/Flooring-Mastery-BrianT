package com.briant.flooring.core;

import java.io.FileNotFoundException;

import com.briant.flooring.dao.FloorDao;
import com.briant.flooring.dao.FloorDaoImpl;
import com.briant.flooring.serv.FloorServ;
import com.briant.flooring.serv.FloorServImpl;
import com.briant.flooring.user.io.FloorIo;
import com.briant.flooring.user.io.FloorIoImpl;

public class FlooringApplication {
    
    public static void main(String[] args) throws FileNotFoundException{
        FloorDao dao = new FloorDaoImpl();
        FloorServ serv = new FloorServImpl(dao);
        FloorIo io = new FloorIoImpl();

        Controller cont = new Controller(io, serv);
        cont.run();
        System.out.println("Exiting..");

    }
}

