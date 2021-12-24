package kpi.mmsa.airport_booking_system.controller;

import kpi.mmsa.airport_booking_system.model.Bill;
import kpi.mmsa.airport_booking_system.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BillController {
    private final BillService billService;
    public BillController(BillService billService){
        this.billService = billService;
    }

    @GetMapping(value = "/bill")
    public ResponseEntity<List<Bill>> getBills(){
        return ResponseEntity.ok(billService.getBills());
    }

    @GetMapping(value = "/bill/{id}")
    public ResponseEntity<Bill> getBill(@PathVariable Long id){
        return ResponseEntity.ok(billService.getBillById(id));
    }

    @PostMapping(value = "/bill")
    public ResponseEntity<Bill> postBill(@Valid @RequestBody Bill newBill){
        return ResponseEntity.ok(billService.saveBill(newBill));
    }

    @PutMapping(value = "/bill/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @Valid @RequestBody Bill updatedBill){
        return ResponseEntity.ok(billService.updateBillPassenger(id, updatedBill));
    }

    @DeleteMapping(value = "/bill/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        return ResponseEntity.ok(billService.deleteBillById(id));
    }
}
