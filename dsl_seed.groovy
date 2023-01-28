folder('SeedJobsFolder') {
    displayName('SeedJobsFolder')
    description('Folder for Seed Jobs')
}

job("SeedJobsFolder/dsl_seed_job"){
    scm {
        github('sgoser/jenkins.casc', 'main')
    }
    steps {
        shell("""
            ls -l /var/lib/jenkins/jobs/
            ls -l /var/lib/jenkins/jobs/SeedJobsFolder/
            ls -l /var/lib/jenkins/jobs/SeedJobsFolder/jobs/
            rm -rf /var/lib/jenkins/jobs/SeedJobsFolder/jobs/0*
            pwd
            ls -l
            mv /var/lib/jenkins/workspace/SeedJobsFolder/dsl_seed_job/jobs/* /var/lib/jenkins/jobs/SeedJobsFolder/jobs/
            ls -l /var/lib/jenkins/jobs/SeedJobsFolder/jobs/
        """)
    }
}