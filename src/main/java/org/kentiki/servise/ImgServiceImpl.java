package org.kentiki.servise;

import lombok.RequiredArgsConstructor;
import org.kentiki.domain.Img;
import org.kentiki.domain.User;
import org.kentiki.model.Answer;
import org.kentiki.repository.ImgRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImgServiceImpl implements ImgService{
    private final ImgRepository imgRepository;

    @Override
    public void insert(Img img) {
        imgRepository.save(img);
    }

    @Override
    public List<Img> getAll() {
        return imgRepository.findAll();
    }

    @Override
    public Img getByName(String name) {
        return imgRepository.findByName(name);
    }

    @Override
    public void update(String name, String date, String user) {
        Img img = Img.builder()
                .name(name)
                .date(date)
                .userName(user)
                .build();
        imgRepository.save(img);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        imgRepository.deleteByName(name);
    }

    @Override
    public Img getRandomeImg() {
        // плохо, но пока ничего не придумал
        List<Img> imgList = imgRepository.findAll();
        int rnd = (int) (Math.random() * imgList.size());
        return imgList.get(rnd);
    }

    @Override
    public String getImgPathFromName(String name) {
        return "/data_img/" + name + ".jpg";
    }

    @Override
    public boolean checkAnswer(Answer answer, Img img) {
        return answer.getDate().equals(img.getDate());
    }
}
