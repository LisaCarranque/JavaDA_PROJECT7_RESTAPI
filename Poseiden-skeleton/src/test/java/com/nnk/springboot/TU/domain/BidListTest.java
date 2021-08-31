package com.nnk.springboot.TU.domain;

import com.nnk.springboot.domain.BidList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BidListTest {

    @Test
    public void getBidList() throws ParseException {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).account("Account")
                .type("Type").askQuantity(10.00).bid(10.00).ask(10.00)
                .benchmark("benchmark").bidListDate(new Timestamp(1000)).commentary("Commentary")
                .security("Security").status("Status").trader("Trader")
                .book("Book").creationName("Creation Name").revisionName("Revision Name")
                .revisionDate(new Timestamp(1000)).creationDate(new Timestamp(1000)).dealName("Deal Name")
                .dealType("Deal Type").sourceListId("Source List Id").side("Side").build();
        assertEquals(Integer.valueOf(1), bidList.getBidListId());
        assertEquals(Double.valueOf(10.00), bidList.getBidQuantity());
        assertEquals("Account", bidList.getAccount());
        assertEquals("Type", bidList.getType());
        assertEquals(Double.valueOf(10.00), bidList.getAskQuantity());
        assertEquals(Double.valueOf(10.00), bidList.getBid());
        assertEquals(Double.valueOf(10.00), bidList.getAsk());
        assertEquals("benchmark", bidList.getBenchmark());
        assertEquals(new Timestamp(1000), bidList.getBidListDate());
        assertEquals("Commentary", bidList.getCommentary());
        assertEquals("Security", bidList.getSecurity());
        assertEquals("Status", bidList.getStatus());
        assertEquals("Trader", bidList.getTrader());
        assertEquals("Book", bidList.getBook());
        assertEquals("Creation Name", bidList.getCreationName());
        assertEquals("Revision Name", bidList.getRevisionName());
        assertEquals(new Timestamp(1000), bidList.getCreationDate());
        assertEquals(new Timestamp(1000), bidList.getRevisionDate());
        assertEquals("Deal Type", bidList.getDealType());
        assertEquals("Deal Name", bidList.getDealName());
        assertEquals("Source List Id", bidList.getSourceListId());
        assertEquals("Side", bidList.getSide());

    }

    @Test
    public void setBidList() {
        BidList bidList = BidList.builder().build();
        bidList.setBidListId(1);
        bidList.setBidQuantity(10.00);
        bidList.setAccount("Account");
        bidList.setType("Type");
        bidList.setAskQuantity(10.00);
        bidList.setBid(10.00);
        bidList.setAsk(10.00);
        bidList.setBenchmark("benchmark");
        bidList.setBidListDate(new Timestamp(1000));
        bidList.setCommentary("Commentary");
        bidList.setSecurity("Security");
        bidList.setStatus("Status");
        bidList.setTrader("Trader");
        bidList.setBook("Book");
        bidList.setCreationName("Creation Name");
        bidList.setRevisionName("Revision Name");
        bidList.setCreationDate(new Timestamp(1000));
        bidList.setRevisionDate(new Timestamp(1000));
        bidList.setDealName("Deal Name");
        bidList.setDealType("Deal Type");
        bidList.setSourceListId("Source List Id");
        bidList.setSide("Side");
        assertEquals(Integer.valueOf(1), bidList.getBidListId());
        assertEquals(Double.valueOf(10.00), bidList.getBidQuantity());
        assertEquals("Account", bidList.getAccount());
        assertEquals("Type", bidList.getType());
        assertEquals(Double.valueOf(10.00), bidList.getAskQuantity());
        assertEquals(Double.valueOf(10.00), bidList.getBid());
        assertEquals(Double.valueOf(10.00), bidList.getAsk());
        assertEquals("benchmark", bidList.getBenchmark());
        assertEquals(new Timestamp(1000), bidList.getBidListDate());
        assertEquals("Commentary", bidList.getCommentary());
        assertEquals("Security", bidList.getSecurity());
        assertEquals("Status", bidList.getStatus());
        assertEquals("Trader", bidList.getTrader());
        assertEquals("Book", bidList.getBook());
        assertEquals("Creation Name", bidList.getCreationName());
        assertEquals("Revision Name", bidList.getRevisionName());
        assertEquals(new Timestamp(1000), bidList.getRevisionDate());
        assertEquals("Deal Type", bidList.getDealType());
        assertEquals("Deal Name", bidList.getDealName());
        assertEquals("Source List Id", bidList.getSourceListId());
        assertEquals("Side", bidList.getSide());
    }

    @Test
    public void testToString() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).account("Account")
                .type("Type").askQuantity(10.00).bid(10.00).ask(10.00)
                .benchmark("benchmark").bidListDate(new Timestamp(1000)).commentary("Commentary")
                .security("Security").status("Status").trader("Trader")
                .book("Book").creationName("Creation Name").revisionName("Revision Name")
                .revisionDate(new Timestamp(1000)).creationDate(new Timestamp(1000)).dealName("Deal Name")
                .dealType("Deal Type").sourceListId("Source List Id").side("Side").build();
        assertEquals( "1",bidList.getBidListId().toString());
        assertEquals( "10.0",bidList.getAskQuantity().toString());
        assertEquals( "10.0",bidList.getBid().toString());
        assertEquals( "10.0",bidList.getAsk().toString());
        assertEquals( "1970-01-01 01:00:01.0",bidList.getBidListDate().toString());
        assertEquals( "1970-01-01 01:00:01.0",bidList.getRevisionDate().toString());
        assertEquals( "1970-01-01 01:00:01.0",bidList.getCreationDate().toString());
        assertNotNull(bidList.toString());
        BidList bidList2 = new BidList();
        assertEquals(bidList2.toString(),bidList2.toString());
    }


}
