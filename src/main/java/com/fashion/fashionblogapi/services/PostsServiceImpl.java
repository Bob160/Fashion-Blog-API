package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.enums.Designs;
import com.fashion.fashionblogapi.pojo.PostsDto;
import com.fashion.fashionblogapi.repositories.PostsRepository;
import com.fashion.fashionblogapi.repositories.UsersRepository;

import java.util.List;

public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    public PostsServiceImpl(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;

        Posts posts = new Posts();
    }

    @Override
    public List<Posts> getAllPosts(Long userId) {
        List<Posts> postsList = postsRepository.findPostsByUsersId(userId);
        return postsList;
    }

    @Override
    public Posts createPosts(PostsDto postsDto) {
        Posts posts = new Posts();
        //private Long id;
        //    private String name;
        //    private Designs designs;
        //    private Date createdAt;
        //    private Date updatedAt;
        posts.setPostTitle(posts.getPostTitle());
        posts.setDesigns(Designs.BLOUSE);
        postsRepository.save(posts);
        return posts;
    }

    @Override
    public Posts getPosts(Long id) {
       Posts posts = postsRepository.findPostsById(id);
        return posts;
    }

    @Override
    public Posts updatePosts(Long id, PostsDto postsDto) {
        if (postsRepository.findPostsById(id).isPresent()) {
            return null;
        }
    }

    @Override
    public void deletePosts(Long id) {
        postsRepository.deletePostsById(id);
    }
}
