package cz.muni.fi.pa165.music_library.dao.interfaces;

import cz.muni.fi.pa165.music_library.data.entities.User;

import java.util.List;

/**
 * @author Filip Mik on 21. 10. 2018
 */

public interface UserDao {

    /**
     * Add new user to persistence
     *
     * @param user User to be added to database(persistence)
     */
    void createUser(User user);

    /**
     * Get all users from the system database
     *
     * @return List of all users found in database, empty list if there are no users
     */
    List<User> getAllUsers();

    /**
     * Find user with given id and return it
     *
     * @param userId Id of searched user
     * @return User object with given id
     */
    User getUserById(Long userId);

    /**
     * Find user with given name and return it
     *
     * @param username Name of searched user
     * @return User object with given username
     */
    User getUserByName(String username);

    /**
     * Find user with given email and return it
     * @param email Email of searched user
     * @return Found user object
     */
    User getUserByEmail(String email);

    /**
     * Delete given user from persistence
     *
     * @param user Searched user
     */
    void deleteUser(User user);

    /**
     * Update user
     *
     * @param user User that will be updated
     */
    void updateUser(User user);
}
