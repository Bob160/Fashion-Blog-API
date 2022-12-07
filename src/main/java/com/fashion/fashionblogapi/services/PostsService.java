package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Comments;
import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.pojo.PostsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface PostsService {
    List<Posts> posts = new ArrayList<>();
    List<Posts> getAllPosts();

    public Posts createPosts(PostsDto postsDto);
    public Posts getPosts(Long id);

    public Posts updatePosts(Long id,PostsDto postsDto);
    public void deletePosts(Long id);
}
