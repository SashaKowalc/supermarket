package com.sasha.supermarket.web.controller;

import com.sasha.supermarket.domain.Purchase;
import com.sasha.supermarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

  @Autowired
  private PurchaseService purchaseService;

  @GetMapping("/all")
  public ResponseEntity<List<Purchase>> getAll() {
    return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/client/{idCliente}")
  public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idCliente") String clientId) {
    return purchaseService.getByClient(clientId)
        .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
    return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
  }

}
