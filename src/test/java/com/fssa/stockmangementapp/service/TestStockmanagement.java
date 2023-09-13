package com.fssa.stockmangementapp.service;

import java.util.List;

import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.util.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.stockmanagementapp.service.StockService;
import com.fssa.stockmanagementapp.model.Stock;

/**
 * This class contains unit tests for the StockService class.
 */
class TestStockmanagement {

    StockService service = new StockService();
    Logger logger = new Logger();

    /**
     * Creates and returns a sample Stock object for testing.
     *
     * @return A sample Stock object.
     */
    public Stock getStock() {
        Stock stock = new Stock("", "US0378331005", "MediaTek Dimensity  Stock", 89.0);
        return stock;
    }

    /**
     * Test the addStock method of the StockService class.
     *
     * @throws InvalidStockDataException if stock data is invalid.
     * @throws StockDAOException if there's an issue with the data access layer.
     */
    @Test
    void testAddStock() throws InvalidStockDataException, StockDAOException {
        Assertions.assertTrue(service.addStock(getStock()));
        logger.info("Stock Added Successfully.");
    }

    /**
     * Test the readAllStocks method of the StockService class.
     *
     * @throws StockDAOException if there's an issue with the data access layer.
     */
    @Test
    void testReadAll() throws StockDAOException {
        List<Stock> list = service.readAllStocks();
        Assertions.assertFalse(list.isEmpty());
        for (Stock ele : list) {
            logger.info(ele);
        }
    }

    /**
     * Test the readByName method of the StockService class.
     *
     * @throws StockDAOException if there's an issue with the data access layer.
     * @throws InvalidStockDataException if stock data is invalid.
     */
    @Test
    void testReadByName() throws StockDAOException, InvalidStockDataException {
        Stock stock = service.readByName("TSLA");
        Assertions.assertNotNull(stock);
        logger.info(stock); 
    }

    /**
     * Test the deleteStock method of the StockService class.
     *
     * @throws StockDAOException if there's an issue with the data access layer.
     */
    @Test
    void testDeleteStock() throws StockDAOException {
        Assertions.assertTrue(service.deleteStock(55));
    }

    /**
     * Test the updateStock method of the StockService class.
     *
     * @throws StockDAOException if there's an issue with the data access layer.
     * @throws InvalidStockDataException if stock data is invalid.
     */
    @Test
    void testUpdateStock() throws StockDAOException, InvalidStockDataException {
    	
    	Stock stock = new Stock();
    	
    	stock.setName("TSLA");
    	stock.setIsin("US88160R1014");
    	stock.setPrice(261);
    	stock.setDescription("TESLA is a Top tech company");
        Assertions.assertTrue(service.updateStock(stock,54));
    }
}
