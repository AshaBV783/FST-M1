import pytest

@pytest.fixture
def sample_list():
    return[1,2,3]
 
@pytest.fixture
def resource():
    conn=open("file.txt","W")
    yield conn
    conn.close()
