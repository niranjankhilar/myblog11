package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class Postserviceimpl implements PostService {
private PostRepository postRepository;

    public Postserviceimpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto){
        post post = new post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post savedpost = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(savedpost.getTitle());
        dto.setDescription(savedpost.getDescription());
        dto.setContent(savedpost.getContent());
        return dto;
    }
}
