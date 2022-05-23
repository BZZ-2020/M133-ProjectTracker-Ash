package com.example.projecttracker.model;

import com.example.projecttracker.data.IssueDataHandler;
import com.example.projecttracker.data.PatchnoteDataHandler;
import com.example.projecttracker.data.TaskDataHandler;
import com.example.projecttracker.data.UserDataHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Project Class for the Project Tracker App
 *
 * @author Alyssa Heimlicher
 * @version 1.0
 * @since 2020-05-20
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    /**
     * The project's unique ID
     *
     * @since 1.0
     */
    private Integer projectId;
    /**
     * The project's name
     *
     * @since 1.0
     */
    private String title;
    /**
     * The project's description
     *
     * @since 1.0
     */
    private String description;
    /**
     * The project's start date
     *
     * @since 1.0
     */
    private String startDate;
    /**
     * Boolean value for whether the project is completed
     *
     * @since 1.0
     */
    private Boolean isFinished;
    /**
     * The project's subject (e.g. CS, Math, etc.)
     *
     * @since 1.0
     */
    private String subject;
    /**
     * The User the project belongs to
     *
     * @since 1.0
     */
    private User user;
    /**
     * The list of issues associated with the project
     *
     * @since 1.0
     */
    private ArrayList<Issue> issues;
    /**
     * The list of tasks associated with the project
     *
     * @since 1.0
     */
    private ArrayList<Task> tasks;
    /**
     * The list of patchNotes associated with the project
     *
     * @since 1.0
     */
    private ArrayList<PatchNote> patchNotes;

    /**
     * gets the userUUID from the User-object
     *
     * @return userUUID
     */
    public String getUserUUID() {
        return getUser().getUserUUID();
    }

    /**
     * creates a User-Object without the project
     *
     * @param userUUID the userUUID of the user
     */
    public void setUserUUID(String userUUID) throws IOException, NoSuchFieldException, IllegalAccessException {
        setUser(new User());
        User user = new UserDataHandler().readUserByUserUUID(userUUID);
        getUser().setUserUUID(userUUID);
        getUser().setUserName(user.getUserName());
        getUser().setPassword(user.getPassword());
        getUser().setUserRole(user.getUserRole());

    }

    public ArrayList<Integer> getTaskIds() {
        ArrayList<Integer> taskIds = new ArrayList<>();
        for (Task task : getTasks()) {
            taskIds.add(task.getTaskId());
        }
        return taskIds;
    }

    public void setTaskIds(ArrayList<Integer> taskIds) throws IOException, NoSuchFieldException, IllegalAccessException {
        TaskDataHandler taskDataHandler = new TaskDataHandler();
        for (Integer taskID : taskIds) {
            getTasks().add(taskDataHandler.readTaskById(taskID));
        }
    }

    public ArrayList<Integer> getIssueIds() {
        ArrayList<Integer> issueIds = new ArrayList<>();
        for (Issue issue : getIssues()) {
            issueIds.add(issue.getIssueId());
        }
        return issueIds;
    }

    public void setIssueIds(ArrayList<Integer> issueIds) throws IOException, NoSuchFieldException, IllegalAccessException {
        IssueDataHandler issueDataHandler = new IssueDataHandler();
        for (Integer taskID : issueIds) {
            getIssues().add(issueDataHandler.readIssueByID(taskID));
        }
    }

    public ArrayList<Integer> getPatchnoteIds() {
        ArrayList<Integer> patchnoteIds = new ArrayList<>();
        for (PatchNote patchnote : getPatchNotes()) {
            patchnoteIds.add(patchnote.getPatchNoteId());
        }
        return patchnoteIds;
    }

    public void setPatchnoteIds(ArrayList<Integer> patchnoteIds) throws IOException, NoSuchFieldException, IllegalAccessException {
        PatchnoteDataHandler patchnoteDataHandler = new PatchnoteDataHandler();
        for (Integer patchnoteId : patchnoteIds) {
            getPatchNotes().add(patchnoteDataHandler.readPatchNoteByID(patchnoteId));
        }
    }
}