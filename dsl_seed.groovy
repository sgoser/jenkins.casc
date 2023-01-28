folder('XMLseedJobsFolder') {
    displayName('XMLseedJobsFolder')
    description('Folder for XML Seed Jobs')
}

job("XMLseedJobsFolder/get_xml_seed_job"){
    scm {
        github('sgoser/jenkins.casc', 'main')
    }
    steps {
        shell("""
            ls -l /var/lib/jenkins/jobs/XMLseedJobsFolder/jobs/
            rm -rf /var/lib/jenkins/jobs/XMLseedJobsFolder/jobs/0*
            pwd
            ls -l
            mv /var/lib/jenkins/workspace/XMLseedJobsFolder/get_xml_seed_job/jobs/* /var/lib/jenkins/jobs/XMLseedJobsFolder/jobs/
            ls -l /var/lib/jenkins/jobs/XMLseedJobsFolder/jobs/
        """)
    }
}