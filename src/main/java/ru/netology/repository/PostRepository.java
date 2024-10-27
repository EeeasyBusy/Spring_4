package ru.netology.repository;

import ru.netology.model.Post;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Stub
public class PostRepository {
    public long count = 0L;
    Map<Long, Post> postMap = new HashMap<>();

    public PostRepository() {
    }

    public Map<Long, Post> all() {
        return postMap;
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(postMap.get(id));
    }

    public synchronized Post save(Post post) {
        if (post.getId() == 0) {
            postMap.put(count, post);
            count++;
            return post;
        } else {
            if (getById(post.getId()).isPresent()) {
                postMap.put(post.getId(), post);
                return post;
            }
            return null;
        }
    }

    public synchronized void removeById(long id) {
        if (postMap.containsKey(id)){
            postMap.remove(id);
        }
        else {
            System.out.println("Пост с таким id не обнаружен");
        }
    }
}
