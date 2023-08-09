package com.fssa.stockmangementapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.util.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.stockmanagementapp.service.StockService;
import com.fssa.stockmanagementapp.model.Stock;

public class TestStockmanagement {

    StockService service = new StockService();

    Logger logger = new Logger();

    public Stock getStock() {
        Stock stock = new Stock("Hemanath", "US-000402625-0", "the stock is good", 30.0, LocalDate.now(),
                LocalTime.now(), LocalDate.now(), LocalTime.now().plusHours(1));

        return stock;
    }

    @Test
    void testAddStock() throws InvalidStockDataException, StockDAOException {

        Assertions.assertTrue(service.addStock(getStock()));

    }

    @Test
    void testReadAll() throws StockDAOException {

        List<Stock> list = service.readAllStocks();

        Assertions.assertFalse(list.isEmpty());

        for (Stock ele : list) {

            logger.info(ele);
        }
    }


    @Test
    void testReadByName() throws StockDAOException, InvalidStockDataException {

        Stock stock = service.readByName("microsoft");
        Assertions.assertNotNull(stock);
        logger.info(stock);

    }

    @Test
    void testDeleteStock() throws StockDAOException {

        Assertions.assertTrue(service.deleteStock(8));
    }

    @Test
    void testUpdateStock() throws StockDAOException, InvalidStockDataException{

        Assertions.assertTrue(service.updateStock("microsoft", "US-000402625-0", 400));
    }


}
