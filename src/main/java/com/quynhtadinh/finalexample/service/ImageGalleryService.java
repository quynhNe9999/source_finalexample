package com.quynhtadinh.finalexample.service;

import java.util.List;
import java.util.Optional;

import com.quynhtadinh.finalexample.entity.ImageGallery;
import com.quynhtadinh.finalexample.repository.ImageGalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class ImageGalleryService {

	@Autowired
	private ImageGalleryRepository imageGalleryRepository;

	public void saveImage(ImageGallery imageGallery) {
		imageGalleryRepository.save(imageGallery);
	}

	public List<ImageGallery> getAllActiveImages() {
		return imageGalleryRepository.findAll();
	}

	public Optional<ImageGallery> getImageById(Long id) {
		return imageGalleryRepository.findById(id);
	}
}

