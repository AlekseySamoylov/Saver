package com.alekseysamoylov.saver.parsing;

import com.alekseysamoylov.saver.models.*;
import com.alekseysamoylov.saver.storages.JDBConnection;
import com.alekseysamoylov.saver.storages.StatementsProperty;
import com.alekseysamoylov.saver.xmlModels.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class ReadOrdersFromDB {
    public synchronized Orders getOrders() {
        Orders orders = new Orders();
        try (Connection connection = new JDBConnection().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    new StatementsProperty().getProperties().getProperty("getOrders"));

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt(1));
                order.setOrderDate(resultSet.getDate(2));

                Manager manager = new Manager();
                manager.setManagerId(resultSet.getInt(3));
                manager.setName(resultSet.getString(4));
                manager.setOther(resultSet.getString(5));

                order.setManager(manager);
                order.setOrderName(resultSet.getString(6));

                ClientsCar clientsCar = new ClientsCar();
                clientsCar.setClientCarId(resultSet.getInt(7));

                //Making car model
                Car car = new Car();
                car.setCarId(resultSet.getInt(8));
                car.setMark(resultSet.getString(9));
                car.setModel(resultSet.getString(10));
                car.setOther(resultSet.getString(11));

                clientsCar.setCar(car);
                //Making client model
                Client client = new Client();
                client.setClientId(resultSet.getInt(12));
                client.setFirstName(resultSet.getString(13));
                client.setSecondName(resultSet.getString(14));
                client.setPhone(resultSet.getString(15));
                client.setOther(resultSet.getString(16));

                clientsCar.setClient(client);
                clientsCar.setCarNumber(resultSet.getString(17));
                //End of making client car


                order.setClientsCar(clientsCar);
                order.setSumm(resultSet.getFloat(18));
                order.setPurchase(resultSet.getFloat(19));

                PreparedStatement preparedStatement = connection.prepareStatement(
                        new StatementsProperty().getProperties().getProperty("getOperations"));
                preparedStatement.setInt(1, order.getOrderId());
                ResultSet operationsResultSet = preparedStatement.executeQuery();
                List<Operation> operationList = new ArrayList<>();
                while (operationsResultSet.next()) {
                    Operation operation = new Operation();
                    operation.setOperationId(operationsResultSet.getInt(1));

                    //Start making master**
                    Master master = new Master();
                    master.setMasterId(operationsResultSet.getInt(2));
                    master.setName(operationsResultSet.getString(3));
                    master.setPhone(operationsResultSet.getString(4));
                    //**End making master

                    operation.setMaster(master);

                    Work work = new Work();
                    work.setWorkId(operationsResultSet.getInt(5));

                    Car carInWork = new Car();
                    carInWork.setCarId(operationsResultSet.getInt(6));
                    carInWork.setMark(operationsResultSet.getString(7));
                    carInWork.setModel(operationsResultSet.getString(8));
                    carInWork.setOther(operationsResultSet.getString(9));

                    work.setCar(carInWork);
                    work.setWorkName(operationsResultSet.getString(10));
                    work.setPrice(operationsResultSet.getFloat(11));
                    work.setOther(operationsResultSet.getString(12));


                    operation.setWork(work);
                    operation.setPrice(operationsResultSet.getFloat(13));
                    operation.setNumberWork(operationsResultSet.getInt(14));
                    operation.setSumm(operationsResultSet.getFloat(15));
                    operation.setOrderId(operationsResultSet.getInt(16));


                    operationList.add(operation);

                }
                order.setOperationList(operationList);


                orders.addOrder(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
