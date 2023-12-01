package org.kentiki.repository;

import org.kentiki.domain.Img;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImgRepository extends JpaRepository<Img, String> {
    Img findByName(String name);
    void deleteByName(String name);
}
