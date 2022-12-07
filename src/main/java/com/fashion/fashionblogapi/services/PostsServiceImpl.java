package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.entities.Users;
import com.fashion.fashionblogapi.enums.Designs;
import com.fashion.fashionblogapi.pojo.PostsDto;
import com.fashion.fashionblogapi.repositories.PostsRepository;
import com.fashion.fashionblogapi.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    @Override
    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }

    @Override
    public Posts createPosts(PostsDto postsDto) {
        Posts posts = new Posts();
        posts.setPostTitle(postsDto.getPostTitle());
        posts.setDesigns(Designs.BLOUSE.name());
        postsRepository.save(posts);
        return posts;
    }

    @Override
    public Posts getPosts(Long id) {
        return postsRepository.findById(id).orElse(null);
    }

    @Override
    public Posts updatePosts(Long id, PostsDto postsDto) {
        Posts existingPosts = postsRepository.findById(id).orElse(null);
        if (existingPosts != null) {
            existingPosts.setPostTitle(postsDto.getPostTitle());
            existingPosts.setDesigns(Designs.BLOUSE.name());
            postsRepository.save(existingPosts);
            return existingPosts;
        }
        return null;
    }

    @Override
    public void deletePosts(Long id) {
        postsRepository.deleteById(id);

    }
}
