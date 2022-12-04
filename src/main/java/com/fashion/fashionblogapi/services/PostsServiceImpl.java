package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.enums.Designs;
import com.fashion.fashionblogapi.pojo.PostsDto;
import com.fashion.fashionblogapi.repositories.PostsRepository;
import com.fashion.fashionblogapi.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    Posts posts = new Posts();

    public PostsServiceImpl(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;


    }

    @Override
    public List<Posts> getAllPosts(Long userId) {
        List<Posts> postsList = postsRepository.findPostsByUsersId(userId);
        return postsList;
    }

    @Override
    public Posts createPosts(PostsDto postsDto) {
        Posts posts = new Posts();
        posts.setPostTitle(posts.getPostTitle());
        posts.setDesigns(Designs.BLOUSE);
        postsRepository.save(posts);
        return posts;
    }

    @Override
    public Posts getPosts(Long id) {
       Posts posts = postsRepository.findPostsById(id).get();
        return posts;
    }

    @Override
    public Posts updatePosts(Long id, PostsDto postsDto) {
        if (postsRepository.findPostsById(id).isPresent()) {
            Posts existingPosts = postsRepository.findPostsById(id).get();
            existingPosts.setPostTitle(postsDto.getPostTitle());
            existingPosts.setDesigns(Designs.BLOUSE);
            postsRepository.save(existingPosts);
            return existingPosts;
        }
        return null;
    }

    @Override
    public void deletePosts(Long id) {
        postsRepository.deletePostsById(id);
    }
}
