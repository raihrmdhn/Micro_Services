package com.tekologiinformasi.restfulapi.order.repository;

import com.tekologiinformasi.restfulapi.order.model.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
