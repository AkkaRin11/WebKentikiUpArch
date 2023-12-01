package org.kentiki.servise;

import org.kentiki.domain.Img;
import org.kentiki.domain.User;
import org.kentiki.model.Answer;

import java.util.List;

public interface ImgService {
    void insert(Img img);

    List<Img> getAll();

    Img getByName(String name);

    void update(String name, String date, String userName);

    void deleteByName(String name);

    Img getRandomeImg();

    String getImgPathFromName(String name);

    boolean checkAnswer(Answer answer, Img img);

}
