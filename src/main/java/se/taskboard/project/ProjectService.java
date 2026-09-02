package se.taskboard.project;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProjectService {
    private final ConcurrentHashMap<UUID, Project> projects = new ConcurrentHashMap<>();

    public Project create(CreateProjectRequest request) {
        Project project = new Project(UUID.randomUUID(), request.name(), request.description(), Instant.now());
        projects.put(project.id(), project);
        return project;
    }

    public Collection<Project> findAll() {
        return projects.values();
    }
}
